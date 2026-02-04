package com.teragrep.buf_01.buffer.supply;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public final class ArenaMemorySegmentSupplier implements MemorySegmentSupplier {

    private final Arena arena;
    private final long count;

    public ArenaMemorySegmentSupplier(final Arena arena, final long count) {
        this.arena = arena;
        this.count = count;
    }


    @Override
    public MemorySegment get() {
        return arena.allocate(ValueLayout.JAVA_BYTE, count);
    }

    @Override
    public void close() {
        arena.close();
    }
}
