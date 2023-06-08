package ma.enset.bdcc.sma;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class SimpleContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);
        AgentController mainAgent=null;
        for (int i = 0; i<4;i++){
            mainAgent = agentContainer.createNewAgent("Island"+String.valueOf(i), QlearningAgent.class.getName(), new Object[]{});
            mainAgent.start();
        }
        mainAgent = agentContainer.createNewAgent("masterAgent", MasterAgentQL.class.getName(), new Object[]{});
        mainAgent.start();
    }
}
