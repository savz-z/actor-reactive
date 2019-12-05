package com.lightbend.model;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class UpdateTCActor  extends AbstractLoggingActor {
	
	 static class UpdateTC{
		 private BaseTC base;
		 public UpdateTC(BaseTC base) {
             this.base = base;
         }
	  }
	
	 private final PartialFunction<Object, BoxedUnit> updateTC;
	 public UpdateTCActor() {

         updateTC = ReceiveBuilder
                 .match(UpdateTC.class, this::onUpdateTC)
                 .build();

         receive(updateTC);
     }
	 
	 private void onUpdateTC(UpdateTC updateTC) {
    	 log().info("inside update");   
    	 System.out.println(updateTC.base.getDep());
    }
	 
	 public static Props props() {
         return Props.create(UpdateTCActor.class);
     }
	
}
