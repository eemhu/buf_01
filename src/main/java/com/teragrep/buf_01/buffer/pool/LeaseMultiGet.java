package com.teragrep.buf_01.buffer.pool;

import com.teragrep.buf_01.buffer.lease.Lease;

import java.lang.foreign.MemorySegment;
import java.util.LinkedList;
import java.util.List;

public final class LeaseMultiGet implements MultiGet<Lease<MemorySegment>> {
    private final CountablePool<Lease<MemorySegment>> leasePool;

    public LeaseMultiGet(final CountablePool<Lease<MemorySegment>> leasePool) {
        this.leasePool = leasePool;
    }

    @Override
    public List<Lease<MemorySegment>> get(final long count) {
        long currentSize = 0;
        final List<Lease<MemorySegment>> leases = new LinkedList<>();
        while (currentSize < count) {
            final Lease<MemorySegment> lease = leasePool.take();
            if (lease == null || lease.isStub()) {
                throw new IllegalStateException("Got stub or null lease from pool!");
            }
            leases.add(lease);
            currentSize += lease.leasedObject().byteSize();
        }
        return leases;
    }
}
