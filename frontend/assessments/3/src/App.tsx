
import { Provider } from 'react-redux'
import './App.css'
import { Home } from './components/ui/Home'
import { Store } from './components/redux/Store'

function App() {

  return(
    <div className ="App" style={{fontFamily: 'Poppins, sans-serif',fontSize:'1.1rem'}}>
    <Provider store = {Store}>
    <Home />
    </Provider>
    </div>
  )
}

export default App
