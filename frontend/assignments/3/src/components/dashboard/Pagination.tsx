import React, { useState } from 'react';
import { Box } from '@mui/material';
import Pagination from '@mui/material/Pagination';

interface Props {
  pageCount: number;
  onPageChange: (page: number) => void;
}

const CustomPagination: React.FC<Props> = ({ pageCount, onPageChange }) => {
  const [currentPage, setCurrentPage] = useState(1);

  const handlePageChange = (event: React.ChangeEvent<unknown>, page: number) => {
    setCurrentPage(page);
    onPageChange(page);
  };

  return (
    <Box mt={2} display="flex" justifyContent="center">
      <Pagination count={pageCount} page={currentPage} onChange={handlePageChange} shape="rounded" siblingCount={0} />
    </Box>
  );
}

export default CustomPagination;
