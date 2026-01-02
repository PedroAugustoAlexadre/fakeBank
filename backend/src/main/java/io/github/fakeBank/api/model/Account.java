package io.github.fakeBank.api.model;

import io.github.fakeBank.api.enums.AccountStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String branch;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String accountCode;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
