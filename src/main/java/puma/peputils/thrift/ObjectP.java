/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package puma.peputils.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-1-21")
public class ObjectP implements org.apache.thrift.TBase<ObjectP, ObjectP._Fields>, java.io.Serializable, Cloneable, Comparable<ObjectP> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ObjectP");

  private static final org.apache.thrift.protocol.TField ATTRIBUTE_VALUES_FIELD_DESC = new org.apache.thrift.protocol.TField("attributeValues", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ObjectPStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ObjectPTupleSchemeFactory());
  }

  public List<AttributeValueP> attributeValues; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ATTRIBUTE_VALUES((short)1, "attributeValues");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ATTRIBUTE_VALUES
          return ATTRIBUTE_VALUES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ATTRIBUTE_VALUES, new org.apache.thrift.meta_data.FieldMetaData("attributeValues", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AttributeValueP.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ObjectP.class, metaDataMap);
  }

  public ObjectP() {
  }

  public ObjectP(
    List<AttributeValueP> attributeValues)
  {
    this();
    this.attributeValues = attributeValues;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ObjectP(ObjectP other) {
    if (other.isSetAttributeValues()) {
      List<AttributeValueP> __this__attributeValues = new ArrayList<AttributeValueP>(other.attributeValues.size());
      for (AttributeValueP other_element : other.attributeValues) {
        __this__attributeValues.add(new AttributeValueP(other_element));
      }
      this.attributeValues = __this__attributeValues;
    }
  }

  public ObjectP deepCopy() {
    return new ObjectP(this);
  }

  @Override
  public void clear() {
    this.attributeValues = null;
  }

  public int getAttributeValuesSize() {
    return (this.attributeValues == null) ? 0 : this.attributeValues.size();
  }

  public java.util.Iterator<AttributeValueP> getAttributeValuesIterator() {
    return (this.attributeValues == null) ? null : this.attributeValues.iterator();
  }

  public void addToAttributeValues(AttributeValueP elem) {
    if (this.attributeValues == null) {
      this.attributeValues = new ArrayList<AttributeValueP>();
    }
    this.attributeValues.add(elem);
  }

  public List<AttributeValueP> getAttributeValues() {
    return this.attributeValues;
  }

  public ObjectP setAttributeValues(List<AttributeValueP> attributeValues) {
    this.attributeValues = attributeValues;
    return this;
  }

  public void unsetAttributeValues() {
    this.attributeValues = null;
  }

  /** Returns true if field attributeValues is set (has been assigned a value) and false otherwise */
  public boolean isSetAttributeValues() {
    return this.attributeValues != null;
  }

  public void setAttributeValuesIsSet(boolean value) {
    if (!value) {
      this.attributeValues = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ATTRIBUTE_VALUES:
      if (value == null) {
        unsetAttributeValues();
      } else {
        setAttributeValues((List<AttributeValueP>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ATTRIBUTE_VALUES:
      return getAttributeValues();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ATTRIBUTE_VALUES:
      return isSetAttributeValues();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ObjectP)
      return this.equals((ObjectP)that);
    return false;
  }

  public boolean equals(ObjectP that) {
    if (that == null)
      return false;

    boolean this_present_attributeValues = true && this.isSetAttributeValues();
    boolean that_present_attributeValues = true && that.isSetAttributeValues();
    if (this_present_attributeValues || that_present_attributeValues) {
      if (!(this_present_attributeValues && that_present_attributeValues))
        return false;
      if (!this.attributeValues.equals(that.attributeValues))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_attributeValues = true && (isSetAttributeValues());
    list.add(present_attributeValues);
    if (present_attributeValues)
      list.add(attributeValues);

    return list.hashCode();
  }

  @Override
  public int compareTo(ObjectP other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAttributeValues()).compareTo(other.isSetAttributeValues());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttributeValues()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attributeValues, other.attributeValues);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ObjectP(");
    boolean first = true;

    sb.append("attributeValues:");
    if (this.attributeValues == null) {
      sb.append("null");
    } else {
      sb.append(this.attributeValues);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ObjectPStandardSchemeFactory implements SchemeFactory {
    public ObjectPStandardScheme getScheme() {
      return new ObjectPStandardScheme();
    }
  }

  private static class ObjectPStandardScheme extends StandardScheme<ObjectP> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ObjectP struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ATTRIBUTE_VALUES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.attributeValues = new ArrayList<AttributeValueP>(_list8.size);
                for (int _i9 = 0; _i9 < _list8.size; ++_i9)
                {
                  AttributeValueP _elem10;
                  _elem10 = new AttributeValueP();
                  _elem10.read(iprot);
                  struct.attributeValues.add(_elem10);
                }
                iprot.readListEnd();
              }
              struct.setAttributeValuesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ObjectP struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.attributeValues != null) {
        oprot.writeFieldBegin(ATTRIBUTE_VALUES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.attributeValues.size()));
          for (AttributeValueP _iter11 : struct.attributeValues)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ObjectPTupleSchemeFactory implements SchemeFactory {
    public ObjectPTupleScheme getScheme() {
      return new ObjectPTupleScheme();
    }
  }

  private static class ObjectPTupleScheme extends TupleScheme<ObjectP> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ObjectP struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAttributeValues()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetAttributeValues()) {
        {
          oprot.writeI32(struct.attributeValues.size());
          for (AttributeValueP _iter12 : struct.attributeValues)
          {
            _iter12.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ObjectP struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.attributeValues = new ArrayList<AttributeValueP>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            AttributeValueP _elem15;
            _elem15 = new AttributeValueP();
            _elem15.read(iprot);
            struct.attributeValues.add(_elem15);
          }
        }
        struct.setAttributeValuesIsSet(true);
      }
    }
  }

}

