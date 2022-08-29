
package modelos;


public class InsumosProductos {
    
    private int id_insumo;
    private int id_producto;
    private int stock_restante;

    public InsumosProductos() {
    }

    public InsumosProductos(int id_insumo, int id_producto, int stock_restante) {
        this.id_insumo = id_insumo;
        this.id_producto = id_producto;
        this.stock_restante = stock_restante;
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getStock_restante() {
        return stock_restante;
    }

    public void setStock_restante(int stock_restante) {
        this.stock_restante = stock_restante;
    }
    
    
    
    
    
    
}
