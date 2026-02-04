package com.teragrep.buf_01.buffer.supply;

import java.lang.foreign.MemorySegment;
import java.util.function.Supplier;

public interface MemorySegmentSupplier extends Supplier<MemorySegment>, AutoCloseable {
    @Override
    MemorySegment get();

    void close();
}
