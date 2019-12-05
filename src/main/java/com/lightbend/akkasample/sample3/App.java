/*
 * Copyright (C) 2009-2017 Lightbend Inc. (https://www.lightbend.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this project except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific 
 * language governing permissions and limitations under the License.
 */
package com.lightbend.akkasample.sample3;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.lightbend.akkasample.StdIn;

/**
 * Supervision
 *
 * see more http://doc.akka.io/docs/akka/2.4/general/supervision.html and
 * http://doc.akka.io/docs/akka/2.4.9/java/lambda-fault-tolerance.html
 */
public class App {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();

        final ActorRef supervisor = system.actorOf(Supervisor.props(), "supervisor");

        for (int i = 0; i < 50; i++) {
            supervisor.tell(new NonTrustWorthyChild.Command(), ActorRef.noSender());
        }

        System.out.println("ENTER to terminate");
        StdIn.readLine();
        system.terminate();
    }
}
