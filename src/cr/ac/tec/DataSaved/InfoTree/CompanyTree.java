package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.Company.Company;
import cr.ac.tec.DataStructures.Tree.SplayTree;
import cr.ac.tec.Files.JsonExchange;

public class CompanyTree extends InfoTree<Company> {
    private static CompanyTree instance;
    private CompanyTree(){
        route="C:\\Users\\migue\\OneDrive\\Documentos\\Proyecto2\\SegundoProyectoDatos1\\web\\Resources\\JsonFiles\\Companies.json";
        Tree=new SplayTree();
        this.getData();
    }
    public  static CompanyTree getInstance(){
        if(instance==null){
            synchronized (CompanyTree.class){
                if(instance==null){
                    instance=new CompanyTree();//Some duplicated code to avoid the threat handler every call, its just used on the first one, before having created and instance
                }
            }
        }
        return instance;
    }
    @Override
    public void getData() {
        Company[] companies=(Company[]) JsonExchange.getObjectFromJson(route,Company[].class);
       Tree.append(companies);
    }
}
