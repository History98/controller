package org.opendaylight.controller.config.yang.config.distributed_datastore_provider;

import org.opendaylight.controller.cluster.datastore.DistributedDataStoreFactory;
import org.opendaylight.controller.cluster.datastore.DistributedDataStoreProperties;
import org.osgi.framework.BundleContext;

public class DistributedOperationalDataStoreProviderModule extends
    org.opendaylight.controller.config.yang.config.distributed_datastore_provider.AbstractDistributedOperationalDataStoreProviderModule {
    private BundleContext bundleContext;

    public DistributedOperationalDataStoreProviderModule(
        org.opendaylight.controller.config.api.ModuleIdentifier identifier,
        org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public DistributedOperationalDataStoreProviderModule(
        org.opendaylight.controller.config.api.ModuleIdentifier identifier,
        org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
        org.opendaylight.controller.config.yang.config.distributed_datastore_provider.DistributedOperationalDataStoreProviderModule oldModule,
        java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {

        OperationalProperties props = getOperationalProperties();
        if(props == null) {
            props = new OperationalProperties();
        }

        return DistributedDataStoreFactory.createInstance("operational",
                getOperationalSchemaServiceDependency(),
                new DistributedDataStoreProperties(
                        props.getMaxShardDataChangeExecutorPoolSize().getValue(),
                        props.getMaxShardDataChangeExecutorQueueSize().getValue(),
                        props.getMaxShardDataChangeListenerQueueSize().getValue(),
                        props.getShardTransactionIdleTimeoutInMinutes().getValue(),
                        props.getOperationTimeoutInSeconds().getValue()), bundleContext);
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

}
