package com.cvshealth.mscoe.common.types;

import java.util.List;

import com.cvshealth.mscoe.common.interfaces.IResource;

public interface Data<T extends IResource> {}

class ResourceData<T extends IResource> implements Data<T> {
  private T value;
  public ResourceData(T value) {
    this.value = value;
  }
}

class CollectionData<T extends IResource> implements Data<T> {
  private List<T> value;
  public CollectionData(List<T> value) {
    this.value = value;
  }
}
