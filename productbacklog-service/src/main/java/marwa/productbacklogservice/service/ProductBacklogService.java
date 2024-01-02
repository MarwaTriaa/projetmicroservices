package marwa.productbacklogservice.service;

import marwa.productbacklogservice.entities.ProductBacklog;
import marwa.productbacklogservice.repo.PBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBacklogService {
    @Autowired
    private PBRepository pbr;
    public ProductBacklog addPB (ProductBacklog pb){
        return pbr.save(pb);
    }
    public List<ProductBacklog> read(){
        return pbr.findAll();
    }
    public ProductBacklog read(long id){
        Optional<ProductBacklog>temp = pbr.findById(id);
        ProductBacklog pb = null;
        if(temp.isPresent()){
            pb=temp.get();
        }
        return pb;
    }
    public ProductBacklog update(ProductBacklog pb){
        Optional<ProductBacklog>temp = pbr.findById(pb.getId());
        if (temp.isPresent()) {
            pbr.save(pb);
            return pb;
        }else{
            return null;
        }

    }
    public ProductBacklog delete(long id){
        Optional<ProductBacklog>temp = pbr.findById(id);
        ProductBacklog pb = null;
        if(temp.isPresent()){
            pb=temp.get();
            pbr.delete(pb);
        }
        return pb;
    }

}
