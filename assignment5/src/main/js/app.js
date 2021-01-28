import React,{useState} from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ModuleOne from './ModuleOne.js';
import ModuleTwo from './ModuleTwo.js';
import ModuleThree from './ModuleThree.js';
import Admin from './Admin.js';
import AdminModuleOne from './AdminModuleOne.js'

const App = () => {
	const [ category, setCategory ] = useState(-1)
	const [ showAdmin, toggleAdmin ] = useState(false)
	const [ cords , setCords ] = useState([])
	const [ center, setCenter ] = useState([22.57,88.36])
	return(
		<Container fluid>
			<Row>
				<Col>
					{showAdmin?<AdminModuleOne toggleAdmin={toggleAdmin}/>:
								<ModuleOne category={category} setCategory={setCategory} toggleAdmin={toggleAdmin}/>}
				</Col>	
			</Row>
			{
				showAdmin?	<Row>
								<Col><Admin/></Col>
							</Row>:	<Row>
										<Col><ModuleTwo cords={cords} center={center}/></Col>
										<Col><ModuleThree setCords={setCords} setCenter={setCenter} category={category}/></Col>
									</Row>
			}			
		</Container>
	);
};
export default App;