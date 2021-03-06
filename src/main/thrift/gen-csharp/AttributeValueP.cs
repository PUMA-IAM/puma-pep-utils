/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Thrift;
using Thrift.Collections;
using System.Runtime.Serialization;
using Thrift.Protocol;
using Thrift.Transport;


#if !SILVERLIGHT
[Serializable]
#endif
public partial class AttributeValueP : TBase
{
  private DataTypeP _dataType;
  private string _id;
  private List<string> _stringValues;
  private List<int> _intValues;
  private List<long> _datetimeValues;
  private List<bool> _booleanValues;

  /// <summary>
  /// 
  /// <seealso cref="DataTypeP"/>
  /// </summary>
  public DataTypeP DataType
  {
    get
    {
      return _dataType;
    }
    set
    {
      __isset.dataType = true;
      this._dataType = value;
    }
  }

  public string Id
  {
    get
    {
      return _id;
    }
    set
    {
      __isset.id = true;
      this._id = value;
    }
  }

  public List<string> StringValues
  {
    get
    {
      return _stringValues;
    }
    set
    {
      __isset.stringValues = true;
      this._stringValues = value;
    }
  }

  public List<int> IntValues
  {
    get
    {
      return _intValues;
    }
    set
    {
      __isset.intValues = true;
      this._intValues = value;
    }
  }

  public List<long> DatetimeValues
  {
    get
    {
      return _datetimeValues;
    }
    set
    {
      __isset.datetimeValues = true;
      this._datetimeValues = value;
    }
  }

  public List<bool> BooleanValues
  {
    get
    {
      return _booleanValues;
    }
    set
    {
      __isset.booleanValues = true;
      this._booleanValues = value;
    }
  }


  public Isset __isset;
  #if !SILVERLIGHT
  [Serializable]
  #endif
  public struct Isset {
    public bool dataType;
    public bool id;
    public bool stringValues;
    public bool intValues;
    public bool datetimeValues;
    public bool booleanValues;
  }

  public AttributeValueP() {
  }

  public void Read (TProtocol iprot)
  {
    TField field;
    iprot.ReadStructBegin();
    while (true)
    {
      field = iprot.ReadFieldBegin();
      if (field.Type == TType.Stop) { 
        break;
      }
      switch (field.ID)
      {
        case 1:
          if (field.Type == TType.I32) {
            DataType = (DataTypeP)iprot.ReadI32();
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        case 2:
          if (field.Type == TType.String) {
            Id = iprot.ReadString();
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        case 3:
          if (field.Type == TType.List) {
            {
              StringValues = new List<string>();
              TList _list0 = iprot.ReadListBegin();
              for( int _i1 = 0; _i1 < _list0.Count; ++_i1)
              {
                string _elem2 = null;
                _elem2 = iprot.ReadString();
                StringValues.Add(_elem2);
              }
              iprot.ReadListEnd();
            }
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        case 4:
          if (field.Type == TType.List) {
            {
              IntValues = new List<int>();
              TList _list3 = iprot.ReadListBegin();
              for( int _i4 = 0; _i4 < _list3.Count; ++_i4)
              {
                int _elem5 = 0;
                _elem5 = iprot.ReadI32();
                IntValues.Add(_elem5);
              }
              iprot.ReadListEnd();
            }
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        case 5:
          if (field.Type == TType.List) {
            {
              DatetimeValues = new List<long>();
              TList _list6 = iprot.ReadListBegin();
              for( int _i7 = 0; _i7 < _list6.Count; ++_i7)
              {
                long _elem8 = 0;
                _elem8 = iprot.ReadI64();
                DatetimeValues.Add(_elem8);
              }
              iprot.ReadListEnd();
            }
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        case 6:
          if (field.Type == TType.List) {
            {
              BooleanValues = new List<bool>();
              TList _list9 = iprot.ReadListBegin();
              for( int _i10 = 0; _i10 < _list9.Count; ++_i10)
              {
                bool _elem11 = false;
                _elem11 = iprot.ReadBool();
                BooleanValues.Add(_elem11);
              }
              iprot.ReadListEnd();
            }
          } else { 
            TProtocolUtil.Skip(iprot, field.Type);
          }
          break;
        default: 
          TProtocolUtil.Skip(iprot, field.Type);
          break;
      }
      iprot.ReadFieldEnd();
    }
    iprot.ReadStructEnd();
  }

  public void Write(TProtocol oprot) {
    TStruct struc = new TStruct("AttributeValueP");
    oprot.WriteStructBegin(struc);
    TField field = new TField();
    if (__isset.dataType) {
      field.Name = "dataType";
      field.Type = TType.I32;
      field.ID = 1;
      oprot.WriteFieldBegin(field);
      oprot.WriteI32((int)DataType);
      oprot.WriteFieldEnd();
    }
    if (Id != null && __isset.id) {
      field.Name = "id";
      field.Type = TType.String;
      field.ID = 2;
      oprot.WriteFieldBegin(field);
      oprot.WriteString(Id);
      oprot.WriteFieldEnd();
    }
    if (StringValues != null && __isset.stringValues) {
      field.Name = "stringValues";
      field.Type = TType.List;
      field.ID = 3;
      oprot.WriteFieldBegin(field);
      {
        oprot.WriteListBegin(new TList(TType.String, StringValues.Count));
        foreach (string _iter12 in StringValues)
        {
          oprot.WriteString(_iter12);
        }
        oprot.WriteListEnd();
      }
      oprot.WriteFieldEnd();
    }
    if (IntValues != null && __isset.intValues) {
      field.Name = "intValues";
      field.Type = TType.List;
      field.ID = 4;
      oprot.WriteFieldBegin(field);
      {
        oprot.WriteListBegin(new TList(TType.I32, IntValues.Count));
        foreach (int _iter13 in IntValues)
        {
          oprot.WriteI32(_iter13);
        }
        oprot.WriteListEnd();
      }
      oprot.WriteFieldEnd();
    }
    if (DatetimeValues != null && __isset.datetimeValues) {
      field.Name = "datetimeValues";
      field.Type = TType.List;
      field.ID = 5;
      oprot.WriteFieldBegin(field);
      {
        oprot.WriteListBegin(new TList(TType.I64, DatetimeValues.Count));
        foreach (long _iter14 in DatetimeValues)
        {
          oprot.WriteI64(_iter14);
        }
        oprot.WriteListEnd();
      }
      oprot.WriteFieldEnd();
    }
    if (BooleanValues != null && __isset.booleanValues) {
      field.Name = "booleanValues";
      field.Type = TType.List;
      field.ID = 6;
      oprot.WriteFieldBegin(field);
      {
        oprot.WriteListBegin(new TList(TType.Bool, BooleanValues.Count));
        foreach (bool _iter15 in BooleanValues)
        {
          oprot.WriteBool(_iter15);
        }
        oprot.WriteListEnd();
      }
      oprot.WriteFieldEnd();
    }
    oprot.WriteFieldStop();
    oprot.WriteStructEnd();
  }

  public override string ToString() {
    StringBuilder __sb = new StringBuilder("AttributeValueP(");
    bool __first = true;
    if (__isset.dataType) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("DataType: ");
      __sb.Append(DataType);
    }
    if (Id != null && __isset.id) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("Id: ");
      __sb.Append(Id);
    }
    if (StringValues != null && __isset.stringValues) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("StringValues: ");
      __sb.Append(StringValues);
    }
    if (IntValues != null && __isset.intValues) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("IntValues: ");
      __sb.Append(IntValues);
    }
    if (DatetimeValues != null && __isset.datetimeValues) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("DatetimeValues: ");
      __sb.Append(DatetimeValues);
    }
    if (BooleanValues != null && __isset.booleanValues) {
      if(!__first) { __sb.Append(", "); }
      __first = false;
      __sb.Append("BooleanValues: ");
      __sb.Append(BooleanValues);
    }
    __sb.Append(")");
    return __sb.ToString();
  }

}

