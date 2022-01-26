import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes
} from "react-router-dom";
import Home from './pages/Home';
import EditarPersonaForm from './pages/EditarPersonaForm';

function App() {
  return (
    <Router>
      <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/persona/:id" element={<EditarPersonaForm/>}/>
        </Routes>
    </Router>
  );
}

export default App;
