/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.yang.model.parser.builder.impl;

import java.util.Collections;
import java.util.List;

import org.opendaylight.controller.yang.common.QName;
import org.opendaylight.controller.yang.model.api.ConstraintDefinition;
import org.opendaylight.controller.yang.model.api.LeafSchemaNode;
import org.opendaylight.controller.yang.model.api.SchemaPath;
import org.opendaylight.controller.yang.model.api.Status;
import org.opendaylight.controller.yang.model.api.TypeDefinition;
import org.opendaylight.controller.yang.model.api.UnknownSchemaNode;
import org.opendaylight.controller.yang.model.parser.builder.api.DataSchemaNodeBuilder;
import org.opendaylight.controller.yang.model.parser.builder.api.SchemaNodeBuilder;
import org.opendaylight.controller.yang.model.parser.builder.api.TypeAwareBuilder;

public class LeafSchemaNodeBuilder implements DataSchemaNodeBuilder,
        SchemaNodeBuilder, TypeAwareBuilder {

    private final QName qname;
    private final LeafSchemaNodeImpl instance;
    private final ConstraintsBuilder constraintsBuilder;
    private TypeDefinition<?> type;

    LeafSchemaNodeBuilder(QName qname) {
        this.qname = qname;
        instance = new LeafSchemaNodeImpl(qname);
        constraintsBuilder = new ConstraintsBuilder();
    }

    @Override
    public LeafSchemaNode build() {
        instance.setConstraints(constraintsBuilder.build());
        return instance;
    }

    @Override
    public QName getQName() {
        return qname;
    }

    @Override
    public void setPath(SchemaPath path) {
        instance.setPath(path);
    }

    @Override
    public void setDescription(String description) {
        instance.setDescription(description);
    }

    @Override
    public void setReference(String reference) {
        instance.setReference(reference);
    }

    @Override
    public void setStatus(Status status) {
        if(status != null) {
            instance.setStatus(status);
        }
    }

    @Override
    public void setAugmenting(boolean augmenting) {
        instance.setAugmenting(augmenting);
    }

    @Override
    public void setConfiguration(boolean configuration) {
        instance.setConfiguration(configuration);
    }

    @Override
    public ConstraintsBuilder getConstraintsBuilder() {
        return constraintsBuilder;
    }

    @Override
    public TypeDefinition<?> getType() {
        return type;
    }

    @Override
    public void setType(TypeDefinition<?> type) {
        this.type = type;
        instance.setType(type);
    }

    private class LeafSchemaNodeImpl implements LeafSchemaNode {
        private final QName qname;
        private SchemaPath path;
        private String description;
        private String reference;
        private Status status = Status.CURRENT;
        private boolean augmenting;
        private boolean configuration;
        private ConstraintDefinition constraints;
        private TypeDefinition<?> type;
        private List<UnknownSchemaNode> unknownSchemaNodes = Collections.emptyList();

        private LeafSchemaNodeImpl(QName qname) {
            this.qname = qname;
        }

        @Override
        public QName getQName() {
            return qname;
        }

        @Override
        public SchemaPath getPath() {
            return path;
        }

        private void setPath(SchemaPath path) {
            this.path = path;
        }

        @Override
        public String getDescription() {
            return description;
        }

        private void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String getReference() {
            return reference;
        }

        private void setReference(String reference) {
            this.reference = reference;
        }

        @Override
        public Status getStatus() {
            return status;
        }

        private void setStatus(Status status) {
            if (status != null) {
                this.status = status;
            }
        }

        @Override
        public boolean isAugmenting() {
            return augmenting;
        }

        private void setAugmenting(boolean augmenting) {
            this.augmenting = augmenting;
        }

        @Override
        public boolean isConfiguration() {
            return configuration;
        }

        private void setConfiguration(boolean configuration) {
            this.configuration = configuration;
        }

        @Override
        public ConstraintDefinition getConstraints() {
            return constraints;
        }

        private void setConstraints(ConstraintDefinition constraints) {
            this.constraints = constraints;
        }

        @Override
        public TypeDefinition<?> getType() {
            return type;
        }

        private void setType(TypeDefinition<? extends TypeDefinition<?>> type) {
            this.type = type;
        }

        @Override
        public List<UnknownSchemaNode> getUnknownSchemaNodes() {
            return unknownSchemaNodes;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((qname == null) ? 0 : qname.hashCode());
            result = prime * result + ((path == null) ? 0 : path.hashCode());
            result = prime * result
                    + ((description == null) ? 0 : description.hashCode());
            result = prime * result
                    + ((reference == null) ? 0 : reference.hashCode());
            result = prime * result
                    + ((status == null) ? 0 : status.hashCode());
            result = prime * result + (augmenting ? 1231 : 1237);
            result = prime * result + (configuration ? 1231 : 1237);
            result = prime * result
                    + ((constraints == null) ? 0 : constraints.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            LeafSchemaNodeImpl other = (LeafSchemaNodeImpl) obj;
            if (qname == null) {
                if (other.qname != null) {
                    return false;
                }
            } else if (!qname.equals(other.qname)) {
                return false;
            }
            if (path == null) {
                if (other.path != null) {
                    return false;
                }
            } else if (!path.equals(other.path)) {
                return false;
            }
            if (description == null) {
                if (other.description != null) {
                    return false;
                }
            } else if (!description.equals(other.description)) {
                return false;
            }
            if (reference == null) {
                if (other.reference != null) {
                    return false;
                }
            } else if (!reference.equals(other.reference)) {
                return false;
            }
            if (status == null) {
                if (other.status != null) {
                    return false;
                }
            } else if (!status.equals(other.status)) {
                return false;
            }
            if (augmenting != other.augmenting) {
                return false;
            }
            if (configuration != other.configuration) {
                return false;
            }
            if (constraints == null) {
                if (other.constraints != null) {
                    return false;
                }
            } else if (!constraints.equals(other.constraints)) {
                return false;
            }
            if (type == null) {
                if (other.type != null) {
                    return false;
                }
            } else if (!type.equals(other.type)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(
                    LeafSchemaNodeImpl.class.getSimpleName());
            sb.append("[");
            sb.append("qname=" + qname);
            sb.append(", path=" + path);
            sb.append(", description=" + description);
            sb.append(", reference=" + reference);
            sb.append(", status=" + status);
            sb.append(", augmenting=" + augmenting);
            sb.append(", configuration=" + configuration);
            sb.append(", constraints=" + constraints);
            sb.append(", type=" + type);
            sb.append(", constraints=" + constraints);
            sb.append("]");
            return sb.toString();
        }
    }

}
