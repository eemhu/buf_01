package com.teragrep.buf_01.buffer.pool;

import java.util.List;

public interface MultiGet<T> {
    public abstract List<T> get(long count);
}
