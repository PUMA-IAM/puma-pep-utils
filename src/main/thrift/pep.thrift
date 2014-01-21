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
  1: DataTypeP dataType,
  2: string id,
  3: optional list<string> stringValues,
  4: optional list<i32> intValues,
  5: optional list<i64> datetimeValues,
  6: optional list<bool> booleanValues,
}

struct SubjectP {
  1: string id,
  2: list<AttributeValueP> attributeValues
}

struct ObjectP {
  1: string id,
  2: list<AttributeValueP> attributeValues
}

struct ActionP {
  1: string id,
  2: list<AttributeValueP> attributeValues
}

struct EnvironmentP {
  1: list<AttributeValueP> attributeValues
}

service RemotePEPService {
  bool isAuthorized(1:SubjectP subject, 2:ObjectP object, 3:ActionP action, 4:EnvironmentP environment)
}
