import axios from "axios";
import { IProduct } from "../interfaces";

const initProduct: IProduct[] = [
  {
    id: 1,
    name: "Monitor samsung 65  pulgadas",
    price: 500,
    description: "El monitor es increible",
  },

  {
    id: 2,
    name: "IPhone 14",
    price: 1200,
    description: "El telefono es muy bueno",
  },

  {
    id: 3,
    name: "Reloj inteligente marca vogue",
    price: 4000,
    description: "Un smartwatch muy premium",
  },
  {
    id: 4,
    name: "Mouse logitech 505",
    price: 30,
    description: "El mouse con mejor calidad precio del mercado",
  },

  {
    id: 5,
    name: "Teclado Kumara 206",
    price: 25,
    description: "Un buen teclado mecanico",
  },
];

export const listProduct = () => {
  return initProduct;
};

const pathUrl: string = "http://localhost:8080/api/products";

export const findAll = async () => {
  try {
    const res = await axios.get(pathUrl);

    return res;
  } catch (error) {
    console.log(error);
  }
};

export const create = async ({ name, description, price }: IProduct) => {
  try {
    const res = await axios.post(pathUrl, {
      name,
      description,
      price,
    });

    return res;
  } catch (error) {
    console.log(error);
  }
};

export const update = async ({id, name,description, price}:IProduct) => {
  try {
    const res = await axios.put(`${pathUrl}/${id}`,{
      name,
      description,
      price
    })

    return res;
  } catch (error) {
    console.log(error);
  }
}

export const remove = async (id:number) => {
  try {
    await axios.delete(`${pathUrl}/${id}`)
  } catch (error) {
    console.log(error);
  }
}