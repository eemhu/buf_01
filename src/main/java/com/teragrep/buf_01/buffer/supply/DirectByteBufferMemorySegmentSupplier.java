package com.teragrep.buf_01.buffer.supply;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

public final class DirectByteBufferMemorySegmentSupplier implements MemorySegmentSupplier{
    private final int count;

    public DirectByteBufferMemorySegmentSupplier(final int count) {
        this.count = count;
    }

    @Override
    public MemorySegment get() {
        return MemorySegment.ofBuffer(ByteBuffer.allocateDirect(count));
    }

    @Override
    public void close() {
        // no-op
    }
}
