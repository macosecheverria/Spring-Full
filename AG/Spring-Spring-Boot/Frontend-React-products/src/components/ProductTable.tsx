import { useEffect, useState } from "react";
import { IProduct } from "../interfaces";
import { ProductTableBody } from "./ProductTableBody";
import { ProductForm } from "./ProductForm";
import { create, findAll, remove, update } from "../helpers";

// const initialProduct:IProduct = {
//   id: 0,
//   name:"",
//   description: "",
//   price: 0
// } 

export const ProductTable = () => {
  const [product, setProduct] = useState<IProduct[]>([]);

  const [productSelected, setProductSelected] = useState<IProduct>(
    {} as IProduct
  );

  const getAllProducts = async () => {
    const result = await findAll();
    // console.log(result);
    setProduct(result?.data);
  } 

  useEffect(() => {
    getAllProducts();
  },[])


  const handlerCreateProduct = async (newProduct: IProduct) => {
    // setProduct([
    //   ...product,
    //   {id: product.length +1, ...newProduct}
    // ])

    if (newProduct.id > 0) {
      const response = await update(newProduct)

      setProduct(
        product.map((prod) => {
          if (prod.id === response?.data.id) {
            return { ...response?.data };
          }

          return prod;
        })
      );
    } else {
      const response = await create(newProduct);

      setProduct([...product, { ...response?.data}]);
    }
  };

  const handlerRemoveProduct = async (id: number) => {
    await remove(id);
    
    setProduct(product.filter((product) => product.id !== id));
  };

  const handlerProductSelected = (product: IProduct) => {
    setProductSelected({ ...product });
  };

  return (
    <div>
      <ProductForm
        handlerCreateProduct={handlerCreateProduct}
        productSelected={productSelected}
      />
      <hr />
      <table className="table table-hover table-striped">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {product.length > 0 ? (
            product.map((values, index) => (
              <ProductTableBody
                key={index}
                {...values}
                handlerRemoveProduct={handlerRemoveProduct}
                handlerProductSelected={handlerProductSelected}
              />
            ))
          ) : (
            <tr>
              <td>No hay productos en el sistema</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};
