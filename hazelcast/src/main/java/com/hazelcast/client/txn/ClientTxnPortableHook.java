package com.hazelcast.client.txn;

import com.hazelcast.nio.serialization.*;

import java.util.Collection;

/**
 * @ali 6/6/13
 */
public class ClientTxnPortableHook implements PortableHook{

    public static final int F_ID = FactoryIdHelper.getFactoryId(FactoryIdHelper.CLIENT_TXN_PORTABLE_FACTORY, -19);

    public static final int CREATE = 1;

    public int getFactoryId() {
        return F_ID;
    }

    public PortableFactory createFactory() {
        final PortableFactory factory = new PortableFactory() {
            public Portable create(int classId) {
                switch (classId){
                    case CREATE:
                        return new CreateTransactionRequest();
                }
                return null;
            }
        };
        return factory;
    }

    public Collection<ClassDefinition> getBuiltinDefinitions() {
        return null;
    }
}
