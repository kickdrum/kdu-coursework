import { TailSpin } from "react-loader-spinner";

const LoaderComp = () => {
	return (
		<TailSpin
			height="20px"
			width="20px"
			color="#4fa94d"
			ariaLabel="tail-spin-loading"
			radius="1"
			wrapperStyle={{}}
			wrapperClass=""
			visible={true}
		/>
	);
}; 
export default LoaderComp;
