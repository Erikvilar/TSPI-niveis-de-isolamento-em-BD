import axios from "axios";

import { useState } from "react";
import TestWith100 from "./tests/TestWith100";
import TestWith1000 from "./tests/TestWith1000";
import TestWith10000 from "./tests/TestWith10000";

function App() {

  const [option, setOption] = useState({title:"Escolha uma das opções abaixo", url:""})

  return (
    <>
      <div>
        
        <h1 style={{ textAlign: "center" }}>{option.title}</h1>
        <div style={{display:"flex", justifyContent:"center"}}>
          <button onClick={()=> setOption({title:"TESTE NA API COM LOCK OTIMISTA", url:"http://192.168.100.5:6680/pedido_otimista/novo"})} style={{backgroundColor:"blue", color:"white", cursor:"pointer"}}>LOCK OTIMISTA</button>
          <button onClick={()=> setOption({title:"TESTE NA API COM LOCK PESSIMISTA", url:"http://192.168.100.5:6680/pedido_pessimista/novo"})} style={{backgroundColor:"blue", color:"white",cursor:"pointer"}}>LOCK PESSIMISTA</button>
          <button onClick={()=> setOption({title:"TESTE NA API SEM LOCK", url:"http://192.168.100.5:6680/pedido/novo"})} style={{backgroundColor:"blue", color:"white",cursor:"pointer"}}>SEM LOCK</button>
         
        </div>
        <div style={{display:"flex",justifyContent:"center", marginTop:15}}>
   
        </div>
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            paddingTop: 200,
            paddingBottom: 100,
          }}
        >
        
          <TestWith100 url={option.url}/>
          <TestWith1000 url={option.url}  />
          <TestWith10000 url={option.url}  />
        </div>
      
      </div>
   
    </>
  );
}

export default App;
