import React,{useState} from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ModuleOne from './ModuleOne.js';
import ModuleTwo from './ModuleTwo.js';
import ModuleThree from './ModuleThree.js';

const App = () => {
	const [ category, setCategory ] = useState(-1)
	const [ cords , setCords] = useState([])
	return(
		<Container>
			<Row>
				<Col><ModuleOne category={category} setCategory={setCategory}/></Col>
			</Row>
			<Row>
				<Col><ModuleTwo cords={cords}/></Col>
				<Col><ModuleThree setCords={setCords} category={category}/></Col>
			</Row>
		</Container>
	);
};
export default App;