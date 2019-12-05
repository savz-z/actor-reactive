package com.lightbend.model;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class CreateTCActor extends AbstractLoggingActor {
	
	 static class CreateTC{
		 private BaseTC base;

         public CreateTC(BaseTC base) {
             this.base = base;
         }
	  }
	 
	 
	
	 private final PartialFunction<Object, BoxedUnit> createTC;
	 public CreateTCActor() {

         createTC = ReceiveBuilder
                 .match(CreateTC.class, this::onCreateTC)
                 .build();

         receive(createTC);
     }
	 
	 private void onCreateTC(CreateTC createTC) {
    	 log().info("inside create");
    	 System.out.println(createTC.base.getDep());
        
    }
	 
	  public static Props props() {
          return Props.create(CreateTCActor.class);
      }
}
