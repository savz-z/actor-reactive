package com.lightbend.model;

import com.lightbend.akkasample.StdIn;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class App {
	public static void main(String[] args) {
        ActorSystem system = ActorSystem.create();

        final ActorRef createTC = system.actorOf(CreateTCActor.props(), "createTC");

        BaseTC base = new BaseTC();
        base.setDep(1);base.setSubdep(2);base.setDepDesc("D1");base.setSubdepDesc("D2");
        createTC.tell(new CreateTCActor.CreateTC(base), ActorRef.noSender());
        BaseTC base1 = new BaseTC();
        base1.setDep(5);base1.setSubdep(6);base1.setDepDesc("D1");base1.setSubdepDesc("D2");
        final ActorRef updateTC = system.actorOf(UpdateTCActor.props(), "updateTC");
        updateTC.tell(new UpdateTCActor.UpdateTC(base1), ActorRef.noSender());

        System.out.println("ENTER to terminate");
        StdIn.readLine();
        system.terminate();
    }
}
