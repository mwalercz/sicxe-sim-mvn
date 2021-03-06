package sicxe.model.simulator.assembler.command;

import javafx.util.Pair;
import sicxe.model.simulator.assembler.SymTab;
import sicxe.model.simulator.assembler.exceptions.NewBaseException;
import sicxe.model.simulator.assembler.exceptions.asm.DuplicateLabelInSymTabException;
import sicxe.model.simulator.assembler.exceptions.asm.NoLabelInSymTabException;
import sicxe.model.simulator.assembler.exceptions.asm.TooLargeOperandException;

/**
 * Created by maciek on 12/01/16.
 */
public abstract class Command {

    protected SymTab symTab;
    protected String baseName = null;
    private String label;
    private Integer location;
    private String sourceCode;


    public Command(String label) {
        this.label = label;
    }

    public void storeLocationInSymTab(Integer location) throws DuplicateLabelInSymTabException {
        symTab.store(label, location);

    }
    public void setSymTab(SymTab symTab) {
        this.symTab = symTab;
    }

    public abstract String translate() throws NoLabelInSymTabException, TooLargeOperandException;
    abstract Integer assignLocation(Integer currentLocation) throws NewBaseException;

    public Integer assign(Integer currentLocation, String baseName)
            throws DuplicateLabelInSymTabException, NewBaseException {
        this.baseName = baseName;
        this.location = currentLocation;
        storeLocationInSymTab(currentLocation);
        return assignLocation(currentLocation);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return  //this.getClass().getSimpleName() + '\n' +
                //symTab +'\n' +
                "loc: "+  Integer.toHexString(location) + "\t" + sourceCode +"\n";
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Integer getLocation() {
        return location;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
