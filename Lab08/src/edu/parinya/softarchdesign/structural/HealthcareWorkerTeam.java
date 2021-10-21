package edu.parinya.softarchdesign.structural;
import java.util.LinkedHashSet;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private LinkedHashSet<HealthcareServiceable> members;

    public HealthcareWorkerTeam() {
        this.members = new LinkedHashSet<HealthcareServiceable>();
    }

    @Override
    public void service() {
        for (HealthcareServiceable member:this.members
             ) {
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (HealthcareServiceable member:this.members
        ) {
            price += member.getPrice();
        }
        return price;
    }

    public void addMember(HealthcareServiceable worker){
        this.members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker){
        this.members.remove(worker);
    }
}
