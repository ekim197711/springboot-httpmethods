package com.example.springboothttpmethods;


import lombok.experimental.FieldNameConstants;

@FieldNameConstants(innerTypeName = "Field")
public enum MyEndpoint {
    @FieldNameConstants.Include
    today,
    @FieldNameConstants.Include
    tomorrow;
}
