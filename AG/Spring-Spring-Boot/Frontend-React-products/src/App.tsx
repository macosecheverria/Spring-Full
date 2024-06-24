import { useState } from 'react'
import './App.css'

export const App = () => {
  const [count, setCount] = useState<number>(0);

  return (
    <>
     <h1>React de Andres Guzman</h1>
     <div>
      <button
        onClick={() => setCount(count + 1)}
      >The count is {count}</button>
     </div>
    </>
  )
}

