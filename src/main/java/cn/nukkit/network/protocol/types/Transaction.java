package cn.nukkit.network.protocol.types;

import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class Transaction {

    TransactionLegacy legacy;
    List<TransactionAction> actions;
    TransactionUseItem data;
}