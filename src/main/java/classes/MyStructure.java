package classes;

import interfaces.IMyStructure;
import interfaces.INode;

import java.util.List;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    public MyStructure(List<INode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public INode findByCode(String code) {
        if (code == null){
            return makeSingleFilteredStream(n -> n.getCode() == null);
        }
        return makeSingleFilteredStream(n -> code.equals(n.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null){
            return makeSingleFilteredStream(n -> n.getRenderer() == null);
        }
        return makeSingleFilteredStream(n -> renderer.equals(n.getRenderer()));
    }

    @Override
    public int count() {
        return nodes == null ? 0 : (int) nodes.stream()
                .flatMap(INode::getStream)
                .count();
    }

    public INode makeSingleFilteredStream (Predicate<INode> predicate){
        return nodes.stream()
                .flatMap(INode::getStream)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
