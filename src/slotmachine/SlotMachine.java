package slotmachine;

import slotmachine.slot.SlotMachineManager;
import slotmachine.slot.SlotResult;

public class SlotMachine {
    private final SlotMachineManager slotMachineManager;

    public SlotMachine() { 
        this.slotMachineManager = new SlotMachineManager();
    }

    public int startSlotModule(int initialCoin) {
        if (initialCoin <= 0) { 
            System.out.println("코인이 없습니다.");
            return initialCoin;
        }

        SlotResult result = slotMachineManager.playSlotGame(initialCoin);
        System.out.println("최종 보유 코인: " + result.getFinalCoin() + "C");
        
        return result.getFinalCoin(); 
    }
}