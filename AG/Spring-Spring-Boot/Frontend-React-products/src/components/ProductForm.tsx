import { ChangeEvent, FormEvent, useEffect, useState } from "react";
import { IProduct } from "../interfaces";

interface Props {
  handlerCreateProduct: (newProduct: IProduct) => void;
  productSelected: IProduct;
}

const initialDataForm: IProduct = {
  id: 0,
  name: "",
  description: "",
  price: 0,
};

export const ProductForm = ({
  handlerCreateProduct,
  productSelected,
}: Props) => {
  const [form, setForm] = useState<IProduct>(initialDataForm);

  const { id, name, description, price } = form;

  useEffect(() => {
    setForm(productSelected);
  }, [productSelected]);

  const onHandleChange = ({ target }: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = target;

    setForm({
      ...form,
      [name]: value,
    });
  };

  const onHandlerReset = () => {
    setForm(initialDataForm);
  };

  const onHandlerSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (!name || !description || !price) {
      alert("Debe de completar los datos del usuario");
    }

    handlerCreateProduct(form);

    setForm(initialDataForm);
  };

  return (
    <form onSubmit={onHandlerSubmit}>
      <div className="mb-3">
        <label className="form-label">Name</label>
        <input
          type="text"
          name="name"
          value={name}
          placeholder="Name"
          onChange={onHandleChange}
          className="form-control mb-2"
        ></input>
        <label className="form-label">Description</label>
        <input
          type="text"
          name="description"
          value={description}
          placeholder="Description"
          onChange={onHandleChange}
          className="form-control mb-2"
        ></input>
        <label className="form-label">Price</label>
        <input
          type="number"
          name="price"
          value={price}
          placeholder="Price"
          onChange={onHandleChange}
          className="form-control mb-2"
        ></input>
      </div>
      <button type="submit" className="btn btn-outline-primary">
        {id > 0 ? "Update" : "Create"}
      </button>
      <button
        type="reset"
        className="btn btn-outline-primary"
        onClick={onHandlerReset}
      >
        Reset
      </button>
    </form>
  );
};
