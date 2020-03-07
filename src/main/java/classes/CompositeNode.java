package classes;

import interfaces.ICompositeNode;
import interfaces.INode;

import java.util.List;

public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> compositeNodeList;

    public CompositeNode(String code, String renderer , List <INode> list) {
        super(code, renderer);
        compositeNodeList = list;
    }

    @Override
    public List<INode> getNodes() {
        return compositeNodeList;
    }
}
