package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private BucketDao ent;
	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	private static BucketService bucketServiceImpl;

	private BucketServiceImpl() {
		try {
			ent = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}

		return bucketServiceImpl;
	}

	@Override
	public Bucket add(Bucket t) {
		return ent.add(t);
	}

	@Override
	public Bucket update(int i, Bucket t) {
		return ent.update(i, t);
	}

	@Override
	public Bucket get(int i) {
		return ent.get(i);
	}

	@Override
	public Bucket delete(int i) {
		return ent.delete(i);
	}

	@Override
	public List<Bucket> getAll() {
		return ent.getAll();
	}
}
