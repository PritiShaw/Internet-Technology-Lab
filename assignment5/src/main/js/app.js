import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ModuleOne from './ModuleOne.js';
import ModuleTwo from './ModuleTwo.js';
import ModuleThree from './ModuleThree.js';

const App = () => {
	return(
		<Container>
			<Row>
				<Col><ModuleOne/></Col>
			</Row>
			<Row>
				<Col><ModuleTwo/></Col>
				<Col><ModuleThree/></Col>
			</Row>
		</Container>
	);
};
export default App;