namespace java puma.peputils.thrift

/**
 * You can define enums, which are just 32 bit integers. Values are optional
 * and start at 1 if not supplied, C style again.
 */
enum DataTypeP {
  STRING = 0;
  INTEGER = 1;
  DATETIME = 2;
  BOOLEAN = 3;
}

struct AttributeValueP {
  1: DataTypeP type,
  2: string id,
  3: optional string string_value,
  4: optional i32 int_value,
  5: optional i64 datetime_value,
  6: optional bool boolean_value,
}

struct SubjectP {
  1: list<AttributeValueP> attributeValues
}

struct ObjectP {
  1: list<AttributeValueP> attributeValues
}

struct ActionP {
  1: list<AttributeValueP> attributeValues
}

struct EnvironmentP {
  1: list<AttributeValueP> attributeValues
}

service RemotePEPService {
  bool isAuthorized(1:SubjectP subject, 2:ObjectP object, 3:ActionP action, 4:EnvironmentP environment)
}
