package com.minkiapps.hos.migration.util;

import com.minkiapps.shared.util.ILogger;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import org.jetbrains.annotations.NotNull;

public class LoggerFacade implements ILogger {

    private static final String TAG_LOG = "MigrationExample";

    private static final int DOMAIN_ID = 0x0001;

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(HiLog.LOG_APP, DOMAIN_ID, LoggerFacade.TAG_LOG);

    private static final String LOG_FORMAT = "%{public}s: %{public}s";

    @Override
    public void debug(@NotNull String tag, @NotNull String message) {
        HiLog.debug(LABEL_LOG, LOG_FORMAT, tag, message);
    }

    @Override
    public void error(@NotNull String tag, @NotNull String message) {
        HiLog.error(LABEL_LOG, LOG_FORMAT, tag, message);
    }
}
