import { IProduct } from "../interfaces";

interface Props {
  id:number;
  name: string;
  description: string;
  price: number;
  handlerRemoveProduct: (id: number) => Promise<void>;
  handlerProductSelected: (product: IProduct) => void;
}

export const ProductTableBody = ({
  id,
  name,
  description,
  price,
  handlerRemoveProduct,
  handlerProductSelected
}: Props) => {

  return (
    <tr>
      <td>{id}</td>
      <td>{name}</td>
      <td>{description}</td>
      <td>{price}</td>
      <td>
        <button
          className="btn btn-outline-warning"
          onClick={() => handlerProductSelected({id, name,description,price})}
        >
          update
        </button>
      </td>
      <td>
        <button
          className="btn btn-outline-danger"
          onClick={() => handlerRemoveProduct(id)}
        >
          remove
        </button>
      </td>
    </tr>
  );
};
