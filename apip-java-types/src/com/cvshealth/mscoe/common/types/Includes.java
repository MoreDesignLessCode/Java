package com.cvshealth.mscoe.common.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cvshealth.mscoe.common.interfaces.IResource;

public class Includes {
	  private Map<String, List<IResource>> map;

	  public Includes() {
	    this.map = new HashMap<String, List<IResource>>();
	  }

	  public void add(String key, IResource resource) {
	    if (this.map.containsKey(key)) {
	      this.map.get(key).add(resource);
	    } else {
	      List<IResource> list = new ArrayList<IResource>();
	      list.add(resource);
	      this.map.put(key, list);
	    }
	  }

	  public List<IResource> get(String key) {
	    return this.map.get(key);
	  }
}
