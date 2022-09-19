package com.aimandaniel;

import java.io.IOException;

import org.eclipse.jetty.server.RequestLog;

/**
 * I wrote this because I didn't realize I could just use Slf4j
 */
final class StdOutWriter implements RequestLog.Writer {
    @Override
    public void write(String requestEntry) throws IOException {
        System.out.println(requestEntry);
    }
}