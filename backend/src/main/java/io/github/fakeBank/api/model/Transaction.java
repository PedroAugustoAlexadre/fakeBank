package io.github.fakeBank.api.model;

import io.github.fakeBank.api.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "TB_TRANSACTION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account sender;

    // optional only necessary TRANSFER
    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private Account receiver;

    @NotNull
    @Positive
    @Column(nullable = false)
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

}
