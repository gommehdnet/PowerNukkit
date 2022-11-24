package cn.nukkit.network.protocol.types.transaction;

import cn.nukkit.network.protocol.types.LegacyTransaction;
import lombok.Value;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class TransactionLegacy {

    long legacyRequestId;
    List<LegacyTransaction> legacyTransactions;
}