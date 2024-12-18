/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package org.pentaho.di.trans.steps.mongodboutput;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pentaho.di.core.injection.BaseMetadataInjectionTest;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LogChannelInterface;
import org.pentaho.di.core.logging.LogChannelInterfaceFactory;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * MDI test for MongoDbOutput.
 */
public class MongoDbOutputMetaInjectionTest extends BaseMetadataInjectionTest<MongoDbOutputMeta> {
  private LogChannelInterfaceFactory oldLogChannelInterfaceFactory;

  @Before
  public void setup() throws IllegalAccessException {
    oldLogChannelInterfaceFactory = KettleLogStore.getLogChannelInterfaceFactory();
    setKettleLogFactoryWithMock();
    setup( new MongoDbOutputMeta() );
  }

  public static void setKettleLogFactoryWithMock() {
    LogChannelInterfaceFactory logChannelInterfaceFactory = mock( LogChannelInterfaceFactory.class );
    LogChannelInterface logChannelInterface = mock( LogChannelInterface.class );
    when( logChannelInterfaceFactory.create( any() ) ).thenReturn(
            logChannelInterface );
    KettleLogStore.setLogChannelInterfaceFactory( logChannelInterfaceFactory );
  }

  @After
  public void tearDown() {
    KettleLogStore.setLogChannelInterfaceFactory( oldLogChannelInterfaceFactory );
  }

  @Test
  public void test() throws Exception {
    check( "TRUNCATE", new BooleanGetter() {
      public boolean get() {
        return meta.m_truncate;
      }
    } );
    check( "UPDATE", new BooleanGetter() {
      public boolean get() {
        return meta.m_update;
      }
    } );
    check( "UPSERT", new BooleanGetter() {
      public boolean get() {
        return meta.m_upsert;
      }
    } );
    check( "MULTI", new BooleanGetter() {
      public boolean get() {
        return meta.m_multi;
      }
    } );
    check( "MODIFIER_UPDATE", new BooleanGetter() {
      public boolean get() {
        return meta.m_modifierUpdate;
      }
    } );
    check( "BATCH_INSERT_SIZE", new StringGetter() {
      public String get() {
        return meta.m_batchInsertSize;
      }
    } );
    check( "RETRY_NUMBER", new StringGetter() {
      public String get() {
        return meta.getWriteRetries();
      }
    } );
    check( "RETRY_DELAY", new StringGetter() {
      public String get() {
        return meta.getWriteRetryDelay();
      }
    } );
    check( "HOSTNAME", new StringGetter() {
      public String get() {
        return meta.getHostnames();
      }
    } );
    check( "PORT", new StringGetter() {
      public String get() {
        return meta.getPort();
      }
    } );
    check( "DATABASE_NAME", new StringGetter() {
      public String get() {
        return meta.getDbName();
      }
    } );
    check( "COLLECTION", new StringGetter() {
      public String get() {
        return meta.getCollection();
      }
    } );
    check( "AUTH_DATABASE", new StringGetter() {
      public String get() {
        return meta.getAuthenticationDatabaseName();
      }
    } );
    check( "AUTH_USERNAME", new StringGetter() {
      public String get() {
        return meta.getAuthenticationUser();
      }
    } );
    check( "AUTH_PASSWORD", new StringGetter() {
      public String get() {
        return meta.getAuthenticationPassword();
      }
    } );
    check( "AUTH_MECHANISM", new StringGetter() {
      public String get() {
        return meta.getAuthenticationMechanism();
      }
    } );
    check( "AUTH_KERBEROS", new BooleanGetter() {
      public boolean get() {
        return meta.getUseKerberosAuthentication();
      }
    } );
    check( "TIMEOUT_CONNECTION", new StringGetter() {
      public String get() {
        return meta.getConnectTimeout();
      }
    } );
    check( "TIMEOUT_SOCKET", new StringGetter() {
      public String get() {
        return meta.getSocketTimeout();
      }
    } );
    check( "USE_SSL_SOCKET_FACTORY", new BooleanGetter() {
      public boolean get() {
        return meta.isUseSSLSocketFactory();
      }
    } );
    check( "USE_CONNECTION_STRING", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.isUseConnectionString();
      }
    } );
    check( "USE_LEGACY_OPTIONS", new BooleanGetter() {
      @Override
      public boolean get() {
        return meta.isUseLegacyOptions();
      }
    } );
    check( "CONNECTION_STRING", new StringGetter() {
      @Override
      public String get() {
        return meta.getConnectionString();
      }
    } );
    check( "READ_PREFERENCE", new StringGetter() {
      public String get() {
        return meta.getReadPreference();
      }
    } );
    check( "USE_ALL_REPLICA_SET_MEMBERS", new BooleanGetter() {
      public boolean get() {
        return meta.getUseAllReplicaSetMembers();
      }
    } );
    check( "INCOMING_FIELD_NAME", new StringGetter() {
      public String get() {
        return meta.getMongoFields().get( 0 ).m_incomingFieldName;
      }
    } );
    check( "MONGO_DOCUMENT_PATH", new StringGetter() {
      public String get() {
        return meta.getMongoFields().get( 0 ).m_mongoDocPath;
      }
    } );
    check( "INCOMING_AS_MONGO", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoFields().get( 0 ).m_useIncomingFieldNameAsMongoFieldName;
      }
    } );
    check( "UPDATE_MATCH_FIELD", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoFields().get( 0 ).m_updateMatchField;
      }
    } );
    check( "MODIFIER_OPERATION", new StringGetter() {
      public String get() {
        return meta.getMongoFields().get( 0 ).m_modifierUpdateOperation;
      }
    } );
    check( "MODIFIER_POLICY", new StringGetter() {
      public String get() {
        return meta.getMongoFields().get( 0 ).m_modifierOperationApplyPolicy;
      }
    } );
    check( "INSERT_NULL", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoFields().get( 0 ).insertNull;
      }
    } );
    check( "JSON", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoFields().get( 0 ).m_JSON;
      }
    } );
    check( "INDEX_FIELD", new StringGetter() {
      public String get() {
        return meta.getMongoIndexes().get( 0 ).m_pathToFields;
      }
    } );
    check( "DROP", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoIndexes().get( 0 ).m_drop;
      }
    } );
    check( "UNIQUE", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoIndexes().get( 0 ).m_unique;
      }
    } );
    check( "SPARSE", new BooleanGetter() {
      public boolean get() {
        return meta.getMongoIndexes().get( 0 ).m_sparse;
      }
    } );
    check( "TAG_SET", new StringGetter() {
      public String get() {
        return meta.getReadPrefTagSets().get( 0 );
      }
    } );
  }
}
