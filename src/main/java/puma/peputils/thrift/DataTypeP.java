/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package puma.peputils.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * You can define enums, which are just 32 bit integers. Values are optional
 * and start at 1 if not supplied, C style again.
 */
public enum DataTypeP implements org.apache.thrift.TEnum {
  STRING(0),
  INTEGER(1),
  DATETIME(2),
  BOOLEAN(3);

  private final int value;

  private DataTypeP(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static DataTypeP findByValue(int value) { 
    switch (value) {
      case 0:
        return STRING;
      case 1:
        return INTEGER;
      case 2:
        return DATETIME;
      case 3:
        return BOOLEAN;
      default:
        return null;
    }
  }
}
