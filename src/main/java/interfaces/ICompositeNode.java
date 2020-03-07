package interfaces;

import java.util.List;
import java.util.stream.Stream;

public interface ICompositeNode extends INode {
    List<INode> getNodes();

    @Override
    default Stream<INode> getStream() {
        return Stream.concat(INode.super.getStream() ,
               this.getNodes().stream().flatMap(INode::getStream));
    }
}
