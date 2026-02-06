package com.teragrep.buf_01.buffer.pool;

import com.teragrep.buf_01.buffer.container.MemorySegmentContainer;
import com.teragrep.buf_01.buffer.lease.MemorySegmentLease;

import java.util.List;

public interface MemorySegmentLeasePool {
    List<MemorySegmentLease> take(long size);

    void close();

    int estimatedSize();

    void internalOffer(MemorySegmentContainer container);
}
