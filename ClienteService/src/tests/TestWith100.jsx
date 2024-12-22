import { useState } from "react";
import axios from "axios";

export default function TestWith100({url}) {
  const [response, setResponse] = useState([]);
  const [cliente, setCliente] = useState([]);
  const [loop, setLoop] = useState(0);
  const [produto, setProduto] = useState([]);
  const [duration, setDuration] = useState(0);



  const makerequests = async () => {
    const quantidade5or1 = Math.floor(Math.random() * 5) + 1;

    const startTime = performance.now();
    try {
     
      const content = {
        clienteID: Math.floor(Math.random() * 5) + 1,
        produtoID: 36,
        valueSpent: 1500.0 * quantidade5or1,
        quantidade: quantidade5or1,
        desconto: 0,
      };
      const response = await axios.post(url, content);

      setResponse(response.status);
      if (response.status === 201) {
        setCliente(response.data.clienteID);
        setProduto(response.data.produtoID);
        setLoop((prevCount) => prevCount + 1);
      }
    } catch (e) {
      console.error(e);
      setResponse(409);
    } finally {
      const endTime = performance.now();
      const measuredDuration = endTime - startTime;
      setDuration(measuredDuration);
    }
  };

  const testLoad100 = async () => {
    setDuration(0);
    setLoop(0);
    try {
      const request = Array.from({ length: 100 }, () =>
        makerequests()
      );
      await Promise.all(request);
    } catch (error) {
      console.log(error);
    }
  };
  const { nome } = cliente;
  const { unidadeEmEstoque } = produto;
  
  return (
    <div
      style={{ borderWidth: 1, borderColor: "red", width: 300, height: 300 }}
    >
      <button
        style={{
          backgroundColor: "yellow",
          cursor: "pointer",
          border: "none",
          padding: 5,
        }}
        onClick={testLoad100}
      >
        TOUCH TO TESTE WITH 100
      </button>
      <p>{response ? <>status {response}</> : <>Sem status</>}</p>
      <p>{loop == 0 ? <>Produto esgotado</> : <>Pedidos realizados{loop}</>}</p>
      <p>Usuario que adiquiriu:{nome}</p>
      <p>Quantidade restante: {unidadeEmEstoque}</p>
      <p>TEMPO TOTAL: {duration.toFixed(2)} ms</p>
      <p>TEMPO MEDIO: {duration.toFixed(2) /100} ms</p>
    </div>
  );
}
