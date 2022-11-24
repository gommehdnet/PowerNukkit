package cn.nukkit.network.protocol.types.transaction;

import cn.nukkit.network.protocol.types.transaction.data.TransactionUseItem;
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
    TransactionUseItem transactionUseItem;
}